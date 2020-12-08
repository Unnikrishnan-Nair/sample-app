package com.sample.app.utl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sample.app.model.Interval;
import com.sample.app.util.ZipCodeIntervalConfigUtil;

public class ZipCodeIntervalConfigUtilTest {

    private ZipCodeIntervalConfigUtil zipCodeIntervalConfigUtil;

    @Before
    public void initializeTestClass() {
        zipCodeIntervalConfigUtil = ZipCodeIntervalConfigUtil.getInstance();
    }

    @Test
    public void testCalculateMinimumRangeOfIntervalsForEmptyInput() {
        try {
            List<Interval> emptyList = new ArrayList<>();
            List<Interval> response = zipCodeIntervalConfigUtil
                    .calculateMinimumRangeOfIntervals(emptyList);
            Assert.assertTrue(response.isEmpty());
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void testCalculateMinimumRangeOfIntervalsForNullInput() {
        try {
            List<Interval> emptyList = null;
            List<Interval> response = zipCodeIntervalConfigUtil
                    .calculateMinimumRangeOfIntervals(emptyList);
            Assert.assertTrue(response.isEmpty());
        } catch (Exception e) {
            Assert.fail();
        }
    }

    // Valid Test Case 1 = [94133,94133] [94200,94299] [94600,94699]

    @Test
    public void testCalculateMinimumRangeOfIntervalsForValidTestCase1() {
        try {
            List<Interval> inputList = Arrays.asList(new Interval(94133, 94133),
                    new Interval(94200, 94299), new Interval(94600, 94699));
            List<Interval> outputList = Arrays.asList(
                    new Interval(94133, 94133), new Interval(94200, 94299),
                    new Interval(94600, 94699));
            List<Interval> response = zipCodeIntervalConfigUtil
                    .calculateMinimumRangeOfIntervals(inputList);
            Assert.assertEquals(outputList.size(), response.size());
            for (int i = 0; i < response.size(); i++) {
                Assert.assertEquals(response.get(i), outputList.get(i));
            }

        } catch (Exception e) {
            Assert.fail();
        }
    }

    // Valid Test Case 2 = [94133,94133] [94200,94299] [94226,94399]

    @Test
    public void testCalculateMinimumRangeOfIntervalsForValidTestCase2() {
        try {
            List<Interval> inputList = Arrays.asList(new Interval(94133, 94133),
                    new Interval(94200, 94299), new Interval(94226, 94399));
            List<Interval> outputList = Arrays.asList(
                    new Interval(94133, 94133), new Interval(94200, 94399));
            List<Interval> response = zipCodeIntervalConfigUtil
                    .calculateMinimumRangeOfIntervals(inputList);
            Assert.assertEquals(outputList.size(), response.size());
            for (int i = 0; i < response.size(); i++) {
                Assert.assertEquals(response.get(i), outputList.get(i));
            }

        } catch (Exception e) {
            Assert.fail();
        }
    }

    // Valid Test Case 3 = ([49679, 52015], [49800, 50000], [51500, 53479],
    // [45012, 46937],
    // [54012,59607], [45500, 45590], [45999, 47900], [44000, 45000], [43012,
    // 45950])

    @Test
    public void testCalculateMinimumRangeOfIntervalsForValidTestCase3() {
        try {
            List<Interval> inputList = Arrays.asList(new Interval(49679, 52015),
                    new Interval(49800, 50000), new Interval(51500, 53479),
                    new Interval(45012, 46937), new Interval(54012, 59607),
                    new Interval(45500, 45590), new Interval(45999, 47900),
                    new Interval(44000, 45000), new Interval(43012, 45950));
            List<Interval> outputList = Arrays.asList(
                    new Interval(43012,47900), new Interval(49679,53479),
                    new Interval(54012,59607));
            List<Interval> response = zipCodeIntervalConfigUtil
                    .calculateMinimumRangeOfIntervals(inputList);
            
            Assert.assertEquals(outputList.size(), response.size());
            
            for (int i = 0; i < response.size(); i++) {
                Assert.assertEquals(response.get(i), outputList.get(i));
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    
    // Valid Test Case 4 = ([49679, 52015])

    @Test
    public void testCalculateMinimumRangeOfIntervalsForValidTestCase4() {
        try {
            List<Interval> inputList = Arrays.asList(new Interval(49679, 52015));
            List<Interval> outputList = Arrays.asList(
                    new Interval(49679, 52015));
            List<Interval> response = zipCodeIntervalConfigUtil
                    .calculateMinimumRangeOfIntervals(inputList);
            Assert.assertEquals(outputList.size(), response.size());
            for (int i = 0; i < response.size(); i++) {
                Assert.assertEquals(response.get(i), outputList.get(i));
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }

}
