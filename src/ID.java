public class ID implements Comparable<ID> {
    private String Name;
    private String Surname;

    public ID(String Name, String Surname) {
        this.Name = Name;
        this.Surname = Surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    @Override
    public int compareTo(ID o) {
        int lastNameComparison = this.Surname.compareTo(o.Surname);
        return (lastNameComparison != 0) ? lastNameComparison : this.Name.compareTo(o.Name);
    }

    @Override
    public String toString() {
        return Name + " " + Surname;
    }
}

