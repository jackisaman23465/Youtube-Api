package com.jagertech.youtubeapi.model.api.dataformat

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("kind")
    var kind: String,
    @SerializedName("etag")
    var etag: String,
    @SerializedName("nextPageToken")
    var nextPageToken: String,
    @SerializedName("prevPageToken")
    var prevPageToken: String,
    @SerializedName("regionCode")
    var regionCode: String,
    @SerializedName("pageInfo")
    var pageInfo: PageInfo,
    @SerializedName("items")
    var items: List<Items>,
)

data class PageInfo(
    @SerializedName("totalResults")
    var totalResults: Long,
    @SerializedName("resultsPerPage")
    var resultsPerPage: Long,
)

data class Items(
    @SerializedName("kind")
    var kind: String,
    @SerializedName("etag")
    var etag: String,
    @SerializedName("id")
    var id: Id,
    @SerializedName("snippet")
    var snippet: Snippet,
)

data class Id(
    @SerializedName("kind")
    var kind: String,
    @SerializedName("videoId")
    var videoId: String,
)

data class Snippet(
    @SerializedName("publishedAt")
    var publishedAt: String,
    @SerializedName("channelId")
    var channelId: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("thumbnails")
    var thumbnails: Thumbnails,
    @SerializedName("channelTitle")
    var channelTitle: String,
    @SerializedName("liveBroadcastContent")
    var liveBroadcastContent: String,
    @SerializedName("publishTime")
    var publishTime: String,
)

data class Thumbnails(
    @SerializedName("default")
    var default: Thumbnail,
    @SerializedName("medium")
    var medium: Thumbnail,
    @SerializedName("high")
    var high: Thumbnail,
)

data class Thumbnail(
    @SerializedName("url")
    var url: String,
    @SerializedName("width")
    var width: Long,
    @SerializedName("height")
    var height: Long,
)