package entity;

import java.io.Serializable;
import java.util.Objects;

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

    public int getSubjectId() {
        return subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeKey)) return false;
        CompositeKey that = (CompositeKey) o;
        return Objects.equals(getSubjectId(), that.getSubjectId()) &&
                Objects.equals(getTeacherId(), that.getTeacherId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubjectId(), getTeacherId());
    }
}
