package com.example.twpruanhong.linechart;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.animation.ChartAnimationListener;
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class MainActivity extends AppCompatActivity {
    private LineChartData chartData;
    private LineChartView chartView;

    private static int LineChartNums = 12;
    private int numberOfLine = 1;
    private int maxNumOfLines = 4;
    private boolean isCubic = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        chartView = (LineChartView) findViewById(R.id.line_chart_view);
        chartView.setInteractive(true);
        chartView.setOnValueTouchListener(new LineChartOnValueSelectListener() {
            @Override
            public void onValueSelected(int lineIndex, int pointIndex, PointValue value) {

            }

            @Override
            public void onValueDeselected() {
                resetViewport();
            }
        });
        chartView.setValueSelectionEnabled(true);
        toggleCubic();
    }
    public void addLineChartData() {
        List<Line> linesList = new ArrayList<>();
        for (int i =0 ; i<numberOfLine; i++ ) {
            List<PointValue> pointValueList = new ArrayList<>();
            Axis axisY = new Axis();
            Axis axisX = new Axis();
            axisX.setName("月");
            axisY.setName("业绩(%)");
            List<AxisValue> axisValueX = new ArrayList<>();
            List<AxisValue> axisValuesY = new ArrayList<>();
//            for (int j = 0; j<LineChartNums; j++ ) {
//                pointValueList.add(new PointValue(j,j*10*(i+1)));
//                axisValuesY.add(new AxisValue(j*10*(i+1)).setLabel(j + ""));
//                axisValueX.add(new AxisValue(j).setLabel(j + "ww"));
//            }
            pointValueList.add(new PointValue(1,10));
            axisValueX.add(new AxisValue(1).setLabel(1 + ""));
            axisValuesY.add(new AxisValue(10).setLabel(1 + ""));

            pointValueList.add(new PointValue(2,30));
            axisValueX.add(new AxisValue(2).setLabel(2 + ""));
            axisValuesY.add(new AxisValue(30).setLabel(3 + ""));

            pointValueList.add(new PointValue(3,40));
            axisValueX.add(new AxisValue(3).setLabel(3 + ""));
            axisValuesY.add(new AxisValue(40).setLabel(4 + ""));

            pointValueList.add(new PointValue(4,50));
            axisValueX.add(new AxisValue(4).setLabel(4 + ""));
            axisValuesY.add(new AxisValue(50).setLabel(5 + ""));

            pointValueList.add(new PointValue(5,90));
            axisValueX.add(new AxisValue(5).setLabel(5 + ""));
            axisValuesY.add(new AxisValue(90).setLabel(9 + ""));

            pointValueList.add(new PointValue(6,40));
            axisValueX.add(new AxisValue(6).setLabel(6 + ""));
            axisValuesY.add(new AxisValue(40).setLabel(4 + ""));

            pointValueList.add(new PointValue(7,30));
            axisValueX.add(new AxisValue(7).setLabel(7 + ""));
            axisValuesY.add(new AxisValue(30).setLabel(3 + ""));

            pointValueList.add(new PointValue(8,50));
            axisValueX.add(new AxisValue(8).setLabel(8 + ""));
            axisValuesY.add(new AxisValue(50).setLabel(5 + ""));

            pointValueList.add(new PointValue(9,50));
            axisValueX.add(new AxisValue(9).setLabel(9 + ""));
            axisValuesY.add(new AxisValue(50).setLabel(5 + ""));

            pointValueList.add(new PointValue(10,60));
            axisValueX.add(new AxisValue(10).setLabel(10 + ""));
            axisValuesY.add(new AxisValue(60).setLabel(6 + ""));

            pointValueList.add(new PointValue(11,80));
            axisValueX.add(new AxisValue(11).setLabel(11 + ""));
            axisValuesY.add(new AxisValue(80).setLabel(8 + ""));

            pointValueList.add(new PointValue(12,70));
            axisValueX.add(new AxisValue(12).setLabel(12 + ""));
            axisValuesY.add(new AxisValue(70).setLabel(7 + ""));

            axisY.setValues(axisValuesY);
            axisX.setValues(axisValueX);
            axisX.setLineColor(Color.BLACK);
            axisY.setLineColor(Color.BLACK);

            axisX.setTextColor(Color.BLACK);
            axisY.setTextColor(Color.BLACK);

            axisX.setTextSize(16);
            axisY.setTextSize(16);
//            axisX.setTypeface(Typeface.SANS_SERIF);
            axisX.setHasLines(true);
            axisY.setHasLines(true);

            axisX.setInside(true);

            Line line = new Line(pointValueList);
            line.setColor(Color.RED);
            line.setStrokeWidth(1);//线条粗细
            line.setFilled(true);
            line.setCubic(isCubic);
            line.setPointColor(Color.BLUE);
            line.setPointRadius(5);
            line.setHasLabels(true);
            line.setHasLines(true);
            line.setHasPoints(true);
            line.setShape(ValueShape.CIRCLE);
            line.setHasLabelsOnlyForSelected(false);//点上label触摸显示
            linesList.add(line);

            chartData = new LineChartData(linesList);
            chartData.setAxisYLeft(axisY);
            chartData.setAxisXBottom(axisX);
            chartData.setBaseValue(14);
            chartData.setValueLabelBackgroundAuto(false);
            chartData.setValueLabelBackgroundColor(Color.GRAY);
            chartData.setValueLabelBackgroundEnabled(false);//线上点的背景
            chartData.setValueLabelsTextColor(Color.RED);
            chartData.setValueLabelTextSize(16);

        }
        chartView.setLineChartData(chartData);
    }
    public void resetViewport() {
        final Viewport viewport = new Viewport(chartView.getMaximumViewport());
        viewport.bottom = 0;
        viewport.top = 100;
        viewport.left = 0;
        viewport.right = LineChartNums -1;
        chartView.setMaximumViewport(viewport);
        chartView.setCurrentViewport(viewport);
    }

    public void toggleCubic() {
        isCubic = !isCubic;
        addLineChartData();
        if (isCubic) {
            final Viewport v = new Viewport(chartView.getMaximumViewport());
            v.bottom = -5;
            v.top = 105;
            chartView.setMaximumViewport(v);
            chartView.setCurrentViewport(v);
        } else {
            final Viewport v = new Viewport(chartView.getMaximumViewport());
            v.bottom = 0;
            v.top = 100;
            chartView.setViewportAnimationListener(new ChartAnimationListener() {
                @Override
                public void onAnimationStarted() {

                }

                @Override
                public void onAnimationFinished() {
                    chartView.setMaximumViewport(v);
                    chartView.setViewportAnimationListener(null);
                }
            });
            chartView.setCurrentViewportWithAnimation(v);
        }
    }
}
