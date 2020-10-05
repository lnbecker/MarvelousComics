# MARVELous Comics
An Android App written in Kotlin that uses the Marvel developer Comics API to retrieve a list of comics. Clicking on a comic in the list will reveal a new screen with comic details (title, description, image) as well as a button to link to that comic online.

## Inserting your API Key and Hash

1. Open app->java->com->retrofit->MarvelComicsApi
2. in the @GET endpoint url string, add your public api key after &apiKey=
3. in the @Get endpoint url string, add your md5 hash value ( md5(ts+publicKey+privateKey)) after &hash=


## Libraries used:
*Retrofit*: HTTP client for Android & Java

*RxJava*: Java VM implementation of ReactiveX. It is library for composing asynchronous and event-based programs by using observable sequences

*Picasso*: an image downloading and caching library for Android

*Espresso*: Android test framework

## App Architecture:
Model-View-Presenter style for the Main Activity with dependency injection for the API service. 

Since all of the data needed for the ComicDetailsActivity was already retrieved in MainActivity, I skipped implementing a Presenter for the second Activity due to the simplicity of the app. In reality, clicking on a recycler view item to show details would probably warrant hitting an API endpoint for that comic ID to get additional details, in which case I would implement a MVP structure

## Important Models

-`MarvelResponse`

-`Result`

-`Comic`

The initial JSON returned by the Marvel Developers API is converted into a `MarvelResponse` object, which is eventually parsed down to a list of comics created from the `Results` field from MarvelResponse->Data->Results. Most models follow the format of the JSON, with the exception of `Comic`. This object is what is returned by the ApiService to be displayed and only contains the properties for title, description, imageUrl, and a webUrl (called detailsUrl in the code)

## Tests

Unit Test: `RetrofitResponseTest` : Tests that Retrofit http call returns non-empty List<Comic> 

UI Test: `RecyclerViewVisibleInstrumentedTest` : Tests that the recycler view is visible, and therefore List<Comic> is not empty. If the list returned by the ComicsApiService is empty, MainActivity displays a textView saying there is no data to display, and the recyclerView visibility = GONE
