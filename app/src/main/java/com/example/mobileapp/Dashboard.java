package com.example.mobileapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);

        // Keep the header below the status bar and the bottom bar above the gesture bar
        View root = findViewById(R.id.root);
        View header = findViewById(R.id.headerBox);
        View bottomBar = findViewById(R.id.bottomBar);
        final int headerTop = header.getPaddingTop();
        ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            header.setPadding(header.getPaddingLeft(), headerTop + bars.top,
                    header.getPaddingRight(), header.getPaddingBottom());
            bottomBar.setPadding(0, 0, 0, bars.bottom);
            return insets;
        });

        SharedPreferences prefs = getSharedPreferences("studex", MODE_PRIVATE);
        String name = prefs.getString("name", "User").trim();
        if (name.isEmpty()) name = "User";

        String role = prefs.getString("role", "");
        if (role.isEmpty()) {
            String prog = prefs.getString("programme", "");
            role = "Lecturer".equalsIgnoreCase(prog) ? "Lecturer" : "Student";
        }

        boolean isLecturer = "Lecturer".equalsIgnoreCase(role);

        ((TextView) findViewById(R.id.tvHello)).setText("Hello, " + name);
        if (name.length() > 0) {
            ((TextView) findViewById(R.id.tvAvatar)).setText(name.substring(0, 1).toUpperCase());
        }
        ((TextView) findViewById(R.id.tvRole)).setText(isLecturer ? "Lecturer" : "Student");

        roundCorners(root);

        // Configure actions according to role
        if (!isLecturer) {
            View tileAdd = findViewById(R.id.tileAdd);
            View tileDelete = findViewById(R.id.tileDelete);
            if (tileAdd != null) tileAdd.setVisibility(View.GONE);
            if (tileDelete != null) tileDelete.setVisibility(View.GONE);
        } else {
            openStudents(R.id.tileAdd, "add");
            openStudents(R.id.tileDelete, "delete");
        }

        openStudents(R.id.tileView, null);
        openStudents(R.id.tileSearch, "search");
        openStudents(R.id.navStudents, null);

        // Navigation for other features
        open(R.id.tileGroups, Groups.class);
        open(R.id.navGroups, Groups.class);
        open(R.id.tileReports, ReportsActivity.class);
        open(R.id.navLabs, LabsActivity.class);
        open(R.id.navMore, SettingsActivity.class);
    }

    private void openStudents(int id, String action) {
        View view = findViewById(id);
        if (view != null) {
            view.setOnClickListener(v -> {
                Intent intent = new Intent(this, StudentsActivity.class);
                if (action != null) intent.putExtra("action", action);
                startActivity(intent);
            });
        }
    }

    private void open(int id, Class<?> screen) {
        View view = findViewById(id);
        if (view != null) {
            view.setOnClickListener(v -> startActivity(new Intent(this, screen)));
        }
    }

    // tag="circle" makes a circle, a number like tag="16" makes rounded corners
    private void roundCorners(View v) {
        Object tag = v.getTag();
        if (tag instanceof String && v.getBackground() instanceof ColorDrawable) {
            GradientDrawable g = new GradientDrawable();
            g.setColor(((ColorDrawable) v.getBackground()).getColor());
            String t = (String) tag;
            if (t.equals("circle")) {
                g.setShape(GradientDrawable.OVAL);
            } else {
                g.setCornerRadius(Float.parseFloat(t)
                        * getResources().getDisplayMetrics().density);
            }
            v.setBackground(g);
        }
        if (v instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) v;
            for (int i = 0; i < group.getChildCount(); i++) {
                roundCorners(group.getChildAt(i));
            }
        }
    }
}