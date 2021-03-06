package com.xhwl.recruitment.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author: guiyu
 * @Description:
 * @Date: Create in 下午4:24 2018/4/22
 **/
@Entity
@Table(name = "dw_training_experience", schema = "xhwl", catalog = "")
public class DwTrainingExperienceEntity {
    private long id;
    private long resumeId;
    private Date startTime;
    private Date endTime;
    private String trainingInstitutions;
    private String trainingContent;
    private String description;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "resume_id", nullable = false)
    public long getResumeId() {
        return resumeId;
    }

    public void setResumeId(long resumeId) {
        this.resumeId = resumeId;
    }

    @Basic
    @Column(name = "start_time", nullable = true)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "training_institutions", nullable = true, length = 255)
    public String getTrainingInstitutions() {
        return trainingInstitutions;
    }

    public void setTrainingInstitutions(String trainingInstitutions) {
        this.trainingInstitutions = trainingInstitutions;
    }

    @Basic
    @Column(name = "training_content", nullable = true, length = 255)
    public String getTrainingContent() {
        return trainingContent;
    }

    public void setTrainingContent(String trainingContent) {
        this.trainingContent = trainingContent;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DwTrainingExperienceEntity that = (DwTrainingExperienceEntity) o;
        return id == that.id &&
                resumeId == that.resumeId &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(trainingInstitutions, that.trainingInstitutions) &&
                Objects.equals(trainingContent, that.trainingContent) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, resumeId, startTime, endTime, trainingInstitutions, trainingContent, description);
    }

    @Override
    public String toString() {
        return "DwTrainingExperienceEntity{" +
                "id=" + id +
                ", resumeId=" + resumeId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", trainingInstitutions='" + trainingInstitutions + '\'' +
                ", trainingContent='" + trainingContent + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
