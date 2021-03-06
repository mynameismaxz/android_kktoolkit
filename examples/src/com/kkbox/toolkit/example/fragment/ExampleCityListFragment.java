package com.kkbox.toolkit.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.kkbox.toolkit.app.KKListFragment;
import com.kkbox.toolkit.example.R;
import com.kkbox.toolkit.example.SampleUtil;

public class ExampleCityListFragment extends KKListFragment {

	private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Bundle bundle = new Bundle();
			if (position == (SampleUtil.test_item.length - 1)) {
				bundle.putString("City", "");
			} else {
				bundle.putString("City", SampleUtil.test_item[position]);
			}
			switchToFragment(new ExampleWeatherFragment(), bundle);
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_listview, container, false);
		initView(view);
		getKKListView().setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, SampleUtil.test_item));
		getKKListView().setOnItemClickListener(onItemClickListener);
		return view;
	}

}
