package vn.edu.iuh.fit.convert;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name = "MaxExp",
        classes = {
                @ConstructorResult(
                        targetClass = MaxExpDTO.class,
                        columns = {
                                @ColumnResult(name = "CandidateID", type = Long.class),
                                @ColumnResult(name = "ExpYear", type = Integer.class)
                        }
                )
        }
)
public class MaxExpDTO {
    private long candidateID;
    private int exp;

    public MaxExpDTO() {
    }

    public long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(long candidateID) {
        this.candidateID = candidateID;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "MaxExpDTO{" +
                "candidateID=" + candidateID +
                ", exp=" + exp +
                '}';
    }
}
