package es.upm.miw.apiArchitectureUser.wrappers;

public class OverageWrapper {
    private double overage;

    public OverageWrapper(double overage) {
        this.setOverage(overage);
    }

    public OverageWrapper() {
        this.setOverage(overage);
    }

    public double getOverage() {
        return overage;
    }

    public void setOverage(double overage) {
        this.overage = overage;
    }

    @Override
    public String toString() {
        return "{\"overage\":" + overage + "}";
    }

}
