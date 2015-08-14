package org.lance.main;

import org.lance.view.PorterDuffView;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * 理解skia 2D图形库的图片合成技术
 * @author ganchengkai
 *
 */
public class MainActivity extends ActionBarActivity implements OnItemSelectedListener {

	private Spinner mSpinner;
	private ArrayAdapter<PorterDuff.Mode> mAdapter;
	private PorterDuffView mPorterDuffView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mPorterDuffView=(PorterDuffView)findViewById(R.id.porter_duff_view);
		
		final PorterDuff.Mode[] modes=PorterDuff.Mode.values();
		
		mAdapter=new ArrayAdapter<PorterDuff.Mode>(this, android.R.layout.simple_spinner_item, modes);
		mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinner=(Spinner)findViewById(R.id.spinner);
		mSpinner.setAdapter(mAdapter);
		
		mSpinner.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		mPorterDuffView.setPorterDuffMode(mAdapter.getItem(position));
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
	}
	
}
