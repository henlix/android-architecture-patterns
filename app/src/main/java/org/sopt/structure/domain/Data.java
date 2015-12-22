package org.sopt.structure.domain;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import org.sopt.structure.BR;

// MVVM Implementation
public class Data extends BaseObservable {

    private ObservableField<Long> id = new ObservableField<>();
    private ObservableField<String> name = new ObservableField<>();
    private ObservableField<String> association = new ObservableField<>();

    public Data(long id, String name, String association) {

        setId(id);
        setName(name);
        setAssociation(association);
    }

    @Bindable
    public long getId() { return id.get(); }
    public void setId(long id) {

        this.id.set(id);
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() { return name.get(); }
    public void setName(String name) {

        this.name.set(name);
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getAssociation() { return association.get(); }
    public void setAssociation(String association) {

        this.association.set(association);
        notifyPropertyChanged(BR.association);
    }

    @Override
    public String toString() { return String.format("%d / %s - %s", id.get(), name.get(), association.get()); }
}

// MVC / MVP Implementation
/*

public class Data {

    private long id;
    private String name;
    private String association;

    public Data(long id, String name, String association) {

        setId(id);
        setName(name);
        setAssociation(association);
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAssociation() { return association; }
    public void setAssociation(String association) { this.association = association; }

    @Override
    public String toString() { return String.format("%d / %s - %s", id, name, association); }
}

*/