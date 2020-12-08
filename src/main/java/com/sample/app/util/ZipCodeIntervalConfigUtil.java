package com.sample.app.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.app.model.Interval;

/**
 * This class is responsible for managing the zipcode values used in the
 * delivery process.
 * 
 * @author unnikrishnan
 *
 */
public class ZipCodeIntervalConfigUtil {

    private static final Logger logger = LoggerFactory
            .getLogger(ZipCodeIntervalConfigUtil.class);

    private static final ZipCodeIntervalConfigUtil instance = new ZipCodeIntervalConfigUtil();

    private ZipCodeIntervalConfigUtil() {
        // private constructor.
    }

    public static ZipCodeIntervalConfigUtil getInstance() {
        return instance;
    }

    /**
     * This method is used to convert the currentIntervals to
     * miniumRangeOfIntervals. For e.g Input = [94133,94133] [94200,94299]
     * [94226,94399] Then the output should be = [94133,94133] [94200,94399] The
     * method will not alter the state of the input List.
     * 
     * @param currentIntervals
     * @return
     */
    public List<Interval> calculateMinimumRangeOfIntervals(
            List<Interval> currentIntervals) {

        logger.debug("Performing minimumRangeInterval calculation");

        // Output List.
        List<Interval> minimumRangeOfIntervals = new ArrayList<>();

        // Empty List Conditions
        if (currentIntervals == null || currentIntervals.isEmpty()) {
            return minimumRangeOfIntervals; // Return Empty Result;
        }

        List<Interval> inputCopyList = new ArrayList<>(currentIntervals);

        Collections.sort(inputCopyList,
                Comparator.comparing(Interval::getStartingVal));

        int currentIntervalStarting = inputCopyList.get(0).getStartingVal();
        int currentIntervalEnding = inputCopyList.get(0).getEndingVal();

        for (int i = 1; i < inputCopyList.size(); i++) {
            Interval nextInterval = inputCopyList.get(i);
            if (currentIntervalEnding >= nextInterval.getStartingVal()) {
                currentIntervalEnding = Math.max(nextInterval.getEndingVal(),
                        currentIntervalEnding);
            } else {
                minimumRangeOfIntervals.add(new Interval(
                        currentIntervalStarting, currentIntervalEnding));
                currentIntervalStarting = nextInterval.getStartingVal();
                currentIntervalEnding = nextInterval.getEndingVal();
            }
        }
        minimumRangeOfIntervals.add(
                new Interval(currentIntervalStarting, currentIntervalEnding));

        logger.debug("Completed minimumRangeInterval calculation");

        return minimumRangeOfIntervals;

    }

}
