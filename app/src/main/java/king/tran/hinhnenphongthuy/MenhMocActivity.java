package king.tran.hinhnenphongthuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MenhMocActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private DatabaseReference reference ;
    private ArrayList<String> list;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menh_moc);

        reference = FirebaseDatabase.getInstance().getReference().child("menhmoc");
        recyclerView= findViewById(R.id.recyclerViewMoc);
        progressBar= findViewById(R.id.progressBarMoc);

        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBar.setVisibility(View.GONE);
                list = new ArrayList<>();
                for (DataSnapshot snapshot1 :snapshot.getChildren()){
                    String data = snapshot1.getValue().toString();
                    list.add(data);
                    // Log.d(TAG,"setVisibility "+data);
                }
                recyclerView.setLayoutManager(new GridLayoutManager(MenhMocActivity.this,2));
                adapter = new UserAdapter(list,MenhMocActivity.this);
                //Log.d(TAG,"setVisibility "+list);
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}