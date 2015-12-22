package org.sopt.structure.architecture.impl.mvp;

public interface EntryPresenter {

    void query();

    EntryView getView();
    void setView(EntryView view);
}
