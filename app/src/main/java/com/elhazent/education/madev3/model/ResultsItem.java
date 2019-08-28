package com.elhazent.education.madev3.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {
	@SerializedName("overview")
	private String overview;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("original_title")
	private String originalTitle;

	@SerializedName("video")
	private boolean video;

	@SerializedName("title")
	private String title;

	@SerializedName("genre_ids")
	private List<Integer> genreIds;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("release_date")
	private String releaseDate;

	@SerializedName("vote_average")
	private double voteAverage;

	@SerializedName("popularity")
	private double popularity;

	@SerializedName("id")
	private int id;

	@SerializedName("adult")
	private boolean adult;

	@SerializedName("vote_count")
	private int voteCount;

	@SerializedName("first_air_date")
	private String firstAirDate;

	@SerializedName("origin_country")
	private List<String> originCountry;

	@SerializedName("original_name")
	private String originalName;

	@SerializedName("name")
	private String name;

	@Override
	public String toString() {
		return "ResultsItem{" +
				"overview='" + overview + '\'' +
				", originalLanguage='" + originalLanguage + '\'' +
				", originalTitle='" + originalTitle + '\'' +
				", video=" + video +
				", title='" + title + '\'' +
				", genreIds=" + genreIds +
				", posterPath='" + posterPath + '\'' +
				", backdropPath='" + backdropPath + '\'' +
				", releaseDate='" + releaseDate + '\'' +
				", voteAverage=" + voteAverage +
				", popularity=" + popularity +
				", id=" + id +
				", adult=" + adult +
				", voteCount=" + voteCount +
				", firstAirDate='" + firstAirDate + '\'' +
				", originCountry=" + originCountry +
				", originalName='" + originalName + '\'' +
				", name='" + name + '\'' +
				'}';
	}

	public ResultsItem(String overview, String originalLanguage, String originalTitle, boolean video, String title, String posterPath, String backdropPath, String releaseDate, double voteAverage, double popularity, int id, boolean adult, int voteCount, String firstAirDate, String originalName, String name) {
		this.overview = overview;
		this.originalLanguage = originalLanguage;
		this.originalTitle = originalTitle;
		this.video = video;
		this.title = title;
		this.posterPath = posterPath;
		this.backdropPath = backdropPath;
		this.releaseDate = releaseDate;
		this.voteAverage = voteAverage;
		this.popularity = popularity;
		this.id = id;
		this.adult = adult;
		this.voteCount = voteCount;
		this.firstAirDate = firstAirDate;
		this.originalName = originalName;
		this.name = name;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public boolean isVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(List<Integer> genreIds) {
		this.genreIds = genreIds;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public double getPopularity() {
		return popularity;
	}

	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public void setFirstAirDate(String firstAirDate) {
		this.firstAirDate = firstAirDate;
	}

	public List<String> getOriginCountry() {
		return originCountry;
	}

	public void setOriginCountry(List<String> originCountry) {
		this.originCountry = originCountry;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.overview);
		dest.writeString(this.originalLanguage);
		dest.writeString(this.originalTitle);
		dest.writeByte(this.video ? (byte) 1 : (byte) 0);
		dest.writeString(this.title);
		dest.writeList(this.genreIds);
		dest.writeString(this.posterPath);
		dest.writeString(this.backdropPath);
		dest.writeString(this.releaseDate);
		dest.writeDouble(this.voteAverage);
		dest.writeDouble(this.popularity);
		dest.writeInt(this.id);
		dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
		dest.writeInt(this.voteCount);
		dest.writeString(this.firstAirDate);
		dest.writeStringList(this.originCountry);
		dest.writeString(this.originalName);
		dest.writeString(this.name);
	}

	protected ResultsItem(Parcel in) {
		this.overview = in.readString();
		this.originalLanguage = in.readString();
		this.originalTitle = in.readString();
		this.video = in.readByte() != 0;
		this.title = in.readString();
		this.genreIds = new ArrayList<Integer>();
		in.readList(this.genreIds, Integer.class.getClassLoader());
		this.posterPath = in.readString();
		this.backdropPath = in.readString();
		this.releaseDate = in.readString();
		this.voteAverage = in.readDouble();
		this.popularity = in.readDouble();
		this.id = in.readInt();
		this.adult = in.readByte() != 0;
		this.voteCount = in.readInt();
		this.firstAirDate = in.readString();
		this.originCountry = in.createStringArrayList();
		this.originalName = in.readString();
		this.name = in.readString();
	}

	public static final Parcelable.Creator<ResultsItem> CREATOR = new Parcelable.Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel source) {
			return new ResultsItem(source);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};
}