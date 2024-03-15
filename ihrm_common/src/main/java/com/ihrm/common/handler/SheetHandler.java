package com.ihrm.common.handler;

import com.ihrm.domain.poi.PoiEntity;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

/**
 * 自动以sheet基于Sax的解析处理器
 */
public class SheetHandler implements XSSFSheetXMLHandler.SheetContentsHandler {

    //封装实体对象
    private PoiEntity entity;

    /**
     * 解析开始
     * @param rowNum
     */
    @Override
    public void startRow(int rowNum) {
        if (rowNum > 0 ){
            entity = new PoiEntity();
        }
    }

    /**
     * 解析结束
     * @param rowNum
     */
    @Override
    public void endRow(int rowNum) {
        System.out.println(entity);
    }

    /**
     * 解析每一个单元格
     * @param cellReference
     * @param formattedValue
     * @param xssfComment
     */
    @Override
    public void cell(String cellReference, String formattedValue, XSSFComment xssfComment) {
         if(entity != null) {
            switch (cellReference.substring(0, 1)) {
                case "A":
                    entity.setId(formattedValue);
                    break;
                case "B":
                    entity.setBreast(formattedValue);
                    break;
                case "C":
                    entity.setAdipocytes(formattedValue);
                    break;
                case "D":
                    entity.setNegative(formattedValue);
                    break;
                case "E":
                    entity.setStaining(formattedValue);
                    break;
                case "F":
                    entity.setSupportive(formattedValue);
                    break;
                default:
                    break;
           }
       }
    }

    //处理头尾
    @Override
    public void headerFooter(String text, boolean isHeader, String tagName) {

    }
}
