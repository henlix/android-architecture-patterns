package org.sopt.structure.architecture.impl.mvvm;

import android.view.View;

import org.sopt.structure.architecture.base.EntryModel;
import org.sopt.structure.databinding.ActivityEntryBinding;
import org.sopt.structure.domain.Data;

public class EntryViewModel {


    ActivityEntryBinding binding;
    EntryModel model;

    public EntryViewModel(ActivityEntryBinding bindingObject) {

        model = new EntryModel();

        binding = bindingObject;
        binding.setViewModel(this);
    }

    public void onClick(View view) {

        Data data = model.query();
        binding.setData(data);

        // MVVM : 데이터 바인딩 테스트 - Data 속성 변경에 대한 View 처리 (멀티 스레딩 고려하지 않음 : 타이머 용도)
        Thread thread = new Thread() {

            private static final int LIMIT = 10;
            private int count = 0;

            @Override
            public void run() {

                while (count++ < LIMIT) {

                    try { Thread.sleep(1000); }
                    catch (InterruptedException e) { e.printStackTrace(); }


                    Data data = binding.getData();

                    long id = data.getId();
                    data.setId(id + 1);
                }
            }
        };

        thread.start();
    }
}
