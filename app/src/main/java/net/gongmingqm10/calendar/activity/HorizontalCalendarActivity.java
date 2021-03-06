package net.gongmingqm10.calendar.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import net.gongmingqm10.calendar.R;
import net.gongmingqm10.calendar.adapter.CalendarPagerAdapter;
import net.gongmingqm10.calendar.util.DateUtil;
import net.gongmingqm10.calendar.view.CalendarCell;

import org.joda.time.LocalDate;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HorizontalCalendarActivity extends ActionBarActivity {

    @InjectView(R.id.horizontal_calendar_pager)
    protected ViewPager calendarPager;
    
    private CalendarPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_calendar);
        ButterKnife.inject(this);
        
        pagerAdapter = new CalendarPagerAdapter(this, DateUtil.getTodaysDate(), calendarItemListener);
        calendarPager.setAdapter(pagerAdapter);
    }

    private View.OnClickListener calendarItemListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CalendarCell calendarCell = (CalendarCell) view;
            LocalDate selectedDate = (LocalDate) calendarCell.getTag();
            pagerAdapter.updateSelectionDate(selectedDate);
            Toast.makeText(HorizontalCalendarActivity.this, "Selected date: " + selectedDate.toString(), Toast.LENGTH_SHORT).show();
        }
    };
}
