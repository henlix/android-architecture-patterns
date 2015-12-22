package org.sopt.structure.architecture.impl.mvp;

import org.sopt.structure.architecture.base.EntryModel;
import org.sopt.structure.domain.Data;

public class EntryPresenterImpl implements EntryPresenter {

    private EntryModel model = new EntryModel();
    private EntryView  view;

    public EntryView getView() { return view; }
    public void setView(EntryView view) { this.view = view; }

    @Override
    public void query() {

        Data data = model.query();
        view.setData(data);
    }
}
