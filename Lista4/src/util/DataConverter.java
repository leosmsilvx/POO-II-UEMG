package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataConverter {
    public static Date converterParaSqlDate(String dataStr) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            java.util.Date dataUtil = formato.parse(dataStr);
            return new java.sql.Date(dataUtil.getTime());
        } catch (ParseException e) {
            System.out.println("Data inválida: " + dataStr);
            return null;
        }
    }

    public static String converterParaString(java.util.Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

}
