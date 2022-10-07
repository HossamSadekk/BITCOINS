## About :thought_balloon:
This is a sample project about MVVM with Clean Architecture i have focused on learning how to implement mvvm with clean architecture and layer responsibilities and which layers should know about the others , creating app and core module and what each one should have of layers.

Layer responsibilities:

- Domain: Contains the business rules of our app. It should provide use cases which reflect the features of our app.
- Presentation: Presents data to the user and also collects necessary data like the username. This is a kind of input/output.
- Model: Provides data for our app. It is responsible for obtaining data from external sources and save them to the database, cloud server, etc.

![App Screenshot](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20220219214201/Clean-Architecture-in-Android.png)

## 🏗️️ Built With

| What            | How                        |
|----------------	|------------------------------	|
| 🎭 User Interface (Android)   | [Jetpack Compose](https://developer.android.com/jetpack/compose)                |
| 🏗 Architecture    | [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)                            |
| 💉 DI (Android)    | [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)                        |
| 🌊 Async            | [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/)                |
| 🌐 Networking        | [Retrofit](https://square.github.io/retrofit/)                        |
| 🧑🏿‍🔬 Testing            | [Junit4](https://junit.org/junit4/)                            |
| 🚀 Turbine            | [Turbine Flow Testing](https://github.com/cashapp/turbine)                            |
