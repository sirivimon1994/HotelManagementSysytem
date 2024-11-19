package datetime;

import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class CustomSpinnerDateModel extends SpinnerDateModel {
	 private static final int STEP = 1; // Change this value to set the step size in days

	 public CustomSpinnerDateModel(Date value, Comparable<?> start, Comparable<?> end, int calendarField) {
	     super();
	}

    @Override
    public Object getNextValue() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getDate());
        calendar.add(Calendar.DAY_OF_MONTH, STEP); // Increment by STEP days
        return calendar.getTime();
    }

    @Override
    public Object getPreviousValue() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getDate());
        calendar.add(Calendar.DAY_OF_MONTH, -STEP); // Decrement by STEP days
        return calendar.getTime();
    }
}