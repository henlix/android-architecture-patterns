package org.sopt.structure;

// 1. MVC Implementation
/*

public class EntryActivity extends AppCompatActivity {

    EntryModel model;
    EntryView  view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_entry);

        model = new EntryModel();
        view = new EntryView(this);

        view.setButtonQueryClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Data data = model.query();
                view.setData(data);
            }
        });
    }
}
*/

// 2. MVP Implementation
/*

public class EntryActivity extends AppCompatActivity implements EntryView {

    TextView textViewName;
    EditText editTextAssociation;
    Button buttonQuery;

    EntryPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);


        presenter = new EntryPresenterImpl();
        presenter.setView(this);


        textViewName = (TextView) findViewById(R.id.text_view_name);
        editTextAssociation = (EditText) findViewById(R.id.edit_text_association);

        buttonQuery = (Button) findViewById(R.id.button_query);
        buttonQuery.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                presenter.query();
            }
        });
    }


    @Override
    public void setData(Data data) {

        textViewName.setText(String.format("%d / %s", data.getId(), data.getName()));
        editTextAssociation.setText(data.getAssociation());
    }
}

*/

// 3. MVVM Implementation

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.sopt.structure.architecture.impl.mvvm.EntryViewModel;
import org.sopt.structure.databinding.ActivityEntryBinding;

public class EntryActivity extends AppCompatActivity {

    ActivityEntryBinding binding;
    EntryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_entry);
        viewModel = new EntryViewModel(binding);
    }
}