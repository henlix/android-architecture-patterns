package org.sopt.structure.architecture.impl.mvc;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.sopt.structure.R;
import org.sopt.structure.domain.Data;

public class EntryView {

    TextView textViewName;
    EditText editTextAssociation;

    Button buttonQuery;
    public void setButtonQueryClickListener(View.OnClickListener listener) { buttonQuery.setOnClickListener(listener); }

    public EntryView(Activity activity) {

        textViewName = (TextView) activity.findViewById(R.id.text_view_name);
        editTextAssociation = (EditText) activity.findViewById(R.id.edit_text_association);

        buttonQuery = (Button) activity.findViewById(R.id.button_query);
    }

    public void setData(Data data) {

        textViewName.setText(String.format("%d / %s", data.getId(), data.getName()));
        editTextAssociation.setText(data.getAssociation());
    }
}
