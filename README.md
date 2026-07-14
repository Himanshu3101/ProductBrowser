# 📱 Product Browser App (Kotlin Multiplatform)

A cross-platform Product Browser application built using **Kotlin Multiplatform (KMP)** and **Compose Multiplatform**. The application consumes product data from the DummyJSON API and demonstrates a clean, scalable architecture with shared business logic and UI for Android and iOS.

The project is configured for both Android and iOS using Kotlin Multiplatform. The application was developed and tested on Android. Building and running the iOS target requires Xcode on macOS.

---

## 📌 Business Requirements

The application provides the following features:

- ✅ Display a list of products
- ✅ View product details
- ✅ Search products using API-based search
- ✅ Display product images
- ✅ Navigate between Product List and Product Detail screens
- ✅ Loading and Error state handling
- ✅ Unit testing for business logic

---

## 📸 Screenshots

Product List 


![](screenshots/product_list.png)

Product Detail 


![](screenshots/product_detail.png)

Search Screen 


![](screenshots/search.png)

---

# 🏗️ Architecture

The project follows **Clean Architecture**, separating responsibilities into independent layers.

```
Presentation Layer
│
├── Screens
├── Components
├── ViewModels
├── UI State
└── Events

        ↓

Domain Layer
│
├── Models
├── Repository Interfaces
└── Use Cases

        ↓

Data Layer
│
├── Remote API
├── DTOs
├── Mappers
└── Repository Implementation
```

### Layer Responsibilities

### Presentation
- Compose Multiplatform UI
- ViewModels
- StateFlow state management
- Navigation

### Domain
- Business logic
- Repository contracts
- Use Cases

### Data
- Ktor networking
- DTOs
- Repository implementation
- API communication

---

# 🚀 Tech Stack

- **Kotlin Multiplatform**
- **Compose Multiplatform**
- **Ktor Client**
- **kotlinx.serialization**
- **StateFlow**
- **Coil 3**
- **Compose Navigation**
- **Kotlin Test**

---

# 📂 Project Structure

```
shared
│
├── core
│   └── network
│
├── data
│   ├── mapper
│   ├── remote
│   │   ├── api
│   │   └── dto
│   └── repository
│
├── domain
│   ├── model
│   ├── repository
│   └── usecase
│
├── presentation
│   ├── components
│   ├── navigation
│   ├── productdetail
│   └── productlist
│
├── di
│
└── App.kt
```

---

# ✨ Features

- Product Listing
- Product Detail Screen
- Search Products
- Product Images
- Loading Indicator
- Error Handling
- Compose Navigation
- Clean Architecture
- Shared UI for Android & iOS
- Unit Test

---

# 🌐 API

This project uses the public DummyJSON API.

### Products

```
https://dummyjson.com/products
```

### Search

```
https://dummyjson.com/products/search?q=phone
```

---

# ⚙️ Build & Run

## Requirements

- Android Studio (latest stable)
- Kotlin Multiplatform Plugin
- JDK 17 or above
- Android SDK
- Xcode (for iOS)

---

## Android

1. Clone the repository

```bash
git clone <repository-url>
```

2. Open the project in Android Studio

3. Sync Gradle

4. Run the **androidApp** configuration.

---

## iOS

1. Open the project in Android Studio

2. Select an iOS Simulator

3. Run the iOS target

*(Requires Xcode on macOS.)*

---

# 🧪 Unit Testing

The project includes a unit test for:

- `GetProductsUseCase`

The use case is tested using a **Fake Repository** to isolate business logic from networking.

---

# 🎯 Design Decisions

- Implemented **Clean Architecture** for better separation of concerns.
- Used **StateFlow** for reactive UI state management.
- Manual Dependency Injection to keep the project lightweight.
- Repository Pattern to abstract data sources.
- Shared UI built using Compose Multiplatform.

---

# ⚖️ Trade-offs

Due to the assessment time constraints:

- Manual Dependency Injection was used instead of Koin.
- Remote API only (no local database or caching).
- Focused on functionality over animations and advanced UI polish.
- Category filtering was not implemented as it was optional.

---

# 🔮 Future Improvements

- Category Filtering
- Offline Caching
- Pagination
- Favorites
- Pull-to-Refresh
- Better Error UI
- Dark Theme Support
- Dependency Injection using Koin
- UI Testing

---

# 📈 Evaluation Checklist

| Requirement | Status |
|-------------|--------|
| Android Support | ✅ |
| iOS Support | ✅ |
| Product List | ✅ |
| Product Detail | ✅ |
| Search | ✅ |
| Clean Architecture | ✅ |
| Ktor Client | ✅ |
| StateFlow | ✅ |
| Use Cases | ✅ |
| Unit Test | ✅ |

---

# 👨‍💻 Author

**Himanshu**

GitHub: https://github.com/Himanshu3101
Linkedin: https://www.linkedin.com/in/himanshu-srivastava3101/

---

## Thank You

Thank you for reviewing this project. Feedback is always appreciated.
