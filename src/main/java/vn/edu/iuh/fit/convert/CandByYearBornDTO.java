package vn.edu.iuh.fit.convert;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name = "CandByYearBorn",
        classes = {
                @ConstructorResult(
                        targetClass = CandByYearBornDTO.class,
                        columns = {
                              @ColumnResult(name = "YearBorn", type = Integer.class),
                                @ColumnResult(name = "Total", type = Long.class)
                        }
                )
        }
)
public class CandByYearBornDTO {
    private int yearBorn;
    private int total;

    public CandByYearBornDTO() {
    }


    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public CandByYearBornDTO(int yearBorn, int total) {
        this.yearBorn = yearBorn;
        this.total = total;
    }

    @Override
    public String toString() {
        return "CandByYearBornDTO{" +
                "yearBorn=" + yearBorn +
                ", total=" + total +
                '}';
    }
}
