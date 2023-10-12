package vn.edu.iuh.fit.convert;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import vn.edu.iuh.fit.entity.Candidate;

@SqlResultSetMapping(
        name = "SkillByCand",
        classes = {
                @ConstructorResult(
                        targetClass = SkillByCandDTO.class,
                        columns = {
                                @ColumnResult(name = "CandidateID", type = Long.class),
                                @ColumnResult(name = "TotalSkill", type = Long.class)
                        }
                )
        }
)
public class SkillByCandDTO {
    private Long candidateID;
    private long totalSkill;

    public SkillByCandDTO() {
    }

    public SkillByCandDTO(Long candidateID, long totalSkill) {
        this.candidateID = candidateID;
        this.totalSkill = totalSkill;
    }

    public Long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Long candidateID) {
        this.candidateID = candidateID;
    }

    public long getTotalSkill() {
        return totalSkill;
    }

    public void setTotalSkill(long totalSkill) {
        this.totalSkill = totalSkill;
    }

    @Override
    public String toString() {
        return "SkillByCandDTO{" +
                "candidateID=" + candidateID +
                ", totalSkill=" + totalSkill +
                '}';
    }
}
