package entity;

import java.io.Serializable;

public class CompositeKey implements Serializable {
    private int teacherId;
    private int subjectId;

    public CompositeKey() {}

    public CompositeKey(int teacherId, int subjectId) {
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

}
