package com.data.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.model.Tweakers;
import com.data.service.TweakersService;
import com.data.util.ResponseCode;
import com.data.util.ResultData;
import com.data.util.TimeUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Component
@PropertySource("classpath:tweakers.properties")
@RequestMapping("/python/tweakers")
public class TweakersController {

    @Autowired
    private TweakersService tweakersService;

    @Value("${temp_path}")
    private String baseDir;

    @GetMapping("/list/byTime")
    ResultData getListByTime(String time){
        ResultData result = new ResultData();
        Map<String,Object> condition = new HashMap<>();
        condition.put("blockFlag",false);
        if(!StringUtils.isEmpty(time)){
            try {
                condition.put("createDate", TimeUtil.dateToStamp(time));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        result = tweakersService.fetch(condition);
        return result;
    }

    @GetMapping("/download")
    public String report_download(String time,HttpServletResponse response){
        ResultData result=new ResultData();
        ResultData resultData = getListByTime(time);
        if(resultData.getResponseCode()!= ResponseCode.RESPONSE_OK){
            return "fail to create excel";
        }
        List<Tweakers> list= (List<Tweakers>)resultData.getData();
        String fileName=new SimpleDateFormat("yyyy-MM-dd").format(list.get(0).getCreateAt())+".xls";
        try{
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("sheet1");
            String[] n = { "编号", "产品类型", "产品名", "供应商" ,"价格","时间"};
            Object[][] value = new Object[list.size() + 1][n.length];
            for (int m = 0; m < n.length; m++) {
                value[0][m] = n[m];
            }
            for (int i = 0; i < list.size(); i++) {
                value[i + 1][0] = list.get(i).getId();
                value[i + 1][1] = list.get(i).getType();
                value[i + 1][2] = list.get(i).getProduct();
                value[i + 1][3] = list.get(i).getName();
                value[i + 1][4] = list.get(i).getPrice();
                value[i + 1][5] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(list.get(i).getCreateAt());
            }
            HSSFRow row[]=new HSSFRow[list.size()+1];
            HSSFCell cell[]=new HSSFCell[n.length];
            for(int i=0;i<row.length;i++){
                row[i]=sheet.createRow(i);
                for(int j=0;j<cell.length;j++){
                    cell[j]=row[i].createCell(j);
                    cell[j].setCellValue(value[i][j].toString());
                }
            }
            OutputStream os = response.getOutputStream();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.addHeader("Content-Disposition", "attachment;filename="+fileName);
            wb.write(os);
            os.close();
        }catch (IOException e) {
            e.printStackTrace();
            return "fail to create excel";
        }
        File file = new File(baseDir);
        try {
            Workbook book = WorkbookFactory.create(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            book.write(byteArrayOutputStream);
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.addHeader("Content-Disposition", "attachment;filename="+fileName);
            response.setContentLength(byteArrayOutputStream.size());
            ServletOutputStream outputstream = response.getOutputStream();
            byteArrayOutputStream.writeTo(outputstream);
            byteArrayOutputStream.close();
            outputstream.flush();
            outputstream.close();
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("fail to create excel");
        }
        return "";
    }
}
