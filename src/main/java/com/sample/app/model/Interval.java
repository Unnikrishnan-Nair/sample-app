package com.sample.app.model;

/**
 * This bean is used to create an instance of an Interval between two integer
 * values.
 * 
 * @author unnikrishnan
 *
 */
public class Interval {

    private Integer startingVal;

    private Integer endingVal;

    public Interval(int startingVal, int endingVal) {
        this.startingVal = startingVal;
        this.endingVal = endingVal;
    }

    public Integer getStartingVal() {
        return startingVal;
    }

    public void setStartingVal(Integer startingVal) {
        this.startingVal = startingVal;
    }

    public Integer getEndingVal() {
        return endingVal;
    }

    public void setEndingVal(Integer endingVal) {
        this.endingVal = endingVal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((endingVal == null) ? 0 : endingVal.hashCode());
        result = prime * result
                + ((startingVal == null) ? 0 : startingVal.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Interval other = (Interval) obj;
        if (endingVal == null) {
            if (other.endingVal != null)
                return false;
        } else if (!endingVal.equals(other.endingVal))
            return false;
        if (startingVal == null) {
            if (other.startingVal != null)
                return false;
        } else if (!startingVal.equals(other.startingVal))
            return false;
        return true;
    }

}
