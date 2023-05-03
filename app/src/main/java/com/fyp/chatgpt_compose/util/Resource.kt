package com.fyp.chatgpt_compose.util

// this class used to catch the state of the api call ( success - failure - loading )
// it's generic so it can be used to wrap any type of response
// data --> response data we fetched
// message --> to determine error message of response

sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    // if response status is success we only need response data
    class Success<T>(data: T?) : Resource<T>(data)

    // if response status is loading we need to get data after being loaded
    // used to show progress bars
    class Loading<T>(data: T? = null) : Resource<T>(data)

    // if response status is failure that means we have no data and should return error message
    class Error<T>(message: String?, data: T? = null) : Resource<T>(data, message)
}