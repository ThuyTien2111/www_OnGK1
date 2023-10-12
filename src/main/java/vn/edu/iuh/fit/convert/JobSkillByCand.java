package vn.edu.iuh.fit.convert;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name = "JobSkillByCand",
        classes = {
                @ConstructorResult(
                        targetClass = JobSkillByCand.class,
                        columns = {
                                @ColumnResult(name = "CandidateID", type = Long.class),
                                @ColumnResult(name = "TotalJob", type = Long.class)
                        }
                )
        }
)
public class JobSkillByCand {
    private long candidateID;
    private long totalJob;

    public JobSkillByCand() {
    }

    public JobSkillByCand(long candidateID, long totalJob) {
        this.candidateID = candidateID;
        this.totalJob = totalJob;
    }

    public long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(long candidateID) {
        this.candidateID = candidateID;
    }

    public long getTotalJob() {
        return totalJob;
    }

    public void setTotalJob(long totalJob) {
        this.totalJob = totalJob;
    }

    @Override
    public String toString() {
        return "JobSkillByCand{" +
                "candidateID=" + candidateID +
                ", totalJob=" + totalJob +
                '}';
    }
}
