package com.ddr1.lalajo.view.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ddr1.lalajo.R;
import com.ddr1.lalajo.model.MovieItem;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvDesc, tvTitle, tvSub, tvDate, tvVote, tvPopuler;
    ImageView imagePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        tvDate = findViewById(R.id.movie_release_date);
        tvVote = findViewById(R.id.movie_rating);
        tvPopuler = findViewById(R.id.movie_revenue);
        tvSub = findViewById(R.id.movie_sub);
        tvTitle = findViewById(R.id.movie_title);
        tvDesc = findViewById(R.id.detail_movie_description);
        imagePhoto = findViewById(R.id.detail_movie_image);

        MovieItem movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String url_image = "https://image.tmdb.org/t/p/w780" + movie.getPoster_path();

        tvDate.setText(movie.getRelease_date());
        tvVote.setText(movie.getVote_average());
        tvPopuler.setText(movie.getPopularity());
        tvSub.setText(movie.getOriginal_language());
        tvTitle.setText(movie.getTitle());
        tvDesc.setText(movie.getOverview());
        Glide.with(DetailMovieActivity.this)
                .load(url_image)
                .placeholder(R.color.colorAccent)
                .dontAnimate()
                .into(imagePhoto);
    }
}
