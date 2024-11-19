//package view;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import org.jdatepicker.impl.AbstractFormatter;
//
//public class DateLabelFormatter extends AbstractFormatter {
//    private String datePattern = "yyyy-MM-dd";
//    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
//
//    @Override
//    public Object stringToValue(String text) throws ParseException {
//        return dateFormatter.parse(text);
//    }
//
//    @Override
//    public String valueToString(Object value) {
//        if (value != null) {
//            return dateFormatter.format((Date) value);
//        }
//        return "";
//    }
//}