package model.entities;

import java.util.Date;
import java.util.Objects;

public class Task implements Comparable<Task>{
    
    private Integer id;
    private String title;
    private Date deadline;
    private String way;
    
    public Task(){}

    public Task(Integer id, String title, Date deadline, String way) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.way = way;
    }
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.deadline);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.deadline, other.deadline)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", task=" + title + ", way=" + way + '}';
    }

    @Override
    public int compareTo(Task other) {
        return deadline.compareTo(other.getDeadline());
    }
    
    
 
    
}
