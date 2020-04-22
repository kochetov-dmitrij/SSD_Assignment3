package action.filter;


import action.Action;

public abstract class Filter implements Action {
    protected double ratio;

    @Override
    public String toString() {
        return "Filter{" +
                "ratio=" + ratio +
                '}';
    }
}
