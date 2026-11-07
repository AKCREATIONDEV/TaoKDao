# TaoKDao

<p align="center">
  <img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.png" width="120" alt="TaoKDao Logo">
</p>

<p align="center">
  <b>An IDE / Code Editor for the Android Platform</b>
</p>

<p align="center">
  <a href="https://github.com/TIIEHenry/TaoKDao">GitHub</a> |
  <a href="http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=310289815">QQ Group: 310289815</a>
</p>

---

## Overview

**TaoKDao** is an integrated development environment (IDE) and code editor built for Android. It aims to deliver a desktop-class IDE workflow (comparable to VS Code and IntelliJ IDEA) on mobile devices. Designed with a modular architecture, it supports dynamic plugin loading, multi-language editing, Language Server Protocol (LSP) integration, and project build systems.

## Features

| Feature | Description |
|---|---|
| **Code Editor** | High-performance, Canvas-rendered editor supporting syntax highlighting, code completion, and folding |
| **LSP Integration** | Language Server Protocol integration for cross-language smart completion and diagnostics (LSP4J integration in progress) |
| **Language Parsing** | ANTLR4-powered AST and syntax parsing for Java, Kotlin, XML, JSON, Markdown, and more |
| **Plugin System** | Dynamic runtime plugin loader allowing APK-based plugins to be installed and unloaded on the fly |
| **Built-in Terminal** | Full terminal emulator powered by the Termux engine with shell execution support |
| **File Management** | Project workspace explorer with Android Storage Access Framework (SAF) integration |
| **Markdown Preview** | Live Markdown preview and rendering powered by Markwon |
| **Project Build** | Configurable build tasks and pipeline orchestration |
| **Themes** | Support for multiple light/dark color palettes and custom skins |
| **Crash Reporting** | Real-time crash capture and native trace reporting via xCrash |

## Screenshots

<p align="center">
  <img src="screenshots/light_java.png" width="45%" alt="Java Editor">
  <img src="screenshots/dark_kotlin.png" width="45%" alt="Kotlin Editor (Dark Theme)">
</p>

<p align="center">
  <img src="screenshots/light_xml.png" width="45%" alt="XML Editor">
  <img src="screenshots/light_explorer.png" width="45%" alt="File Explorer">
</p>

## Architecture

### Pattern

The project implements the **MVP (Model-View-Presenter)** design pattern. `MainActivity` acts as the root host container, delegating distinct business domains across 20+ specialized Presenters.

### Project Structure

```text
TaoKDao/
├── app/                    # Main application module
│   └── tiiehenry.taokdao   # Entry point & app orchestration
├── common/                 # Base common library (AppCompat, RecyclerView, ViewBinding)
├── CodeEditor/             # Core code editor (Canvas rendering engine, LSP4J)
├── CodeEditorAntlr/        # ANTLR4 language parsing extensions
├── DynamicLoader/          # Runtime plugin loading framework
├── encodedetector/         # File charset & encoding detector
├── encodehelper/           # Charset conversion helpers
├── filej/                  # File operations library
├── api_public/             # Public plugin API interfaces
├── api_skin/               # Theme and skinning API
├── terminal-emulator/      # Terminal emulation core engine
├── terminal-view/          # Terminal UI view component
└── markwon-editor/         # Markdown editor component
```

### Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Kotlin | 2.3.0 | Primary application language |
| Java | 17 | Compatibility layer & tool libraries |
| Android Gradle Plugin | 9.0.0 | Android build system |
| Gradle | 9.1.0 | Build automation tool |
| minSdk / targetSdk | 28 / 36 | Android OS compatibility target |
| LSP4J | 0.10.0 | Language Server Protocol Java binding |
| ANTLR4 | 4.8 | Parser generator for grammar analysis |
| Markwon | 4.6.2 | Markdown parser and renderer |
| MMKV | 2.3.0 | High-performance key-value storage |
| Velocity | 3.1 | Template engine for file scaffolding |
| XPopup | 1.9.12 | UI popups and overlay management |
| Material Dialogs | 3.3.0 | Dialog framework |
| AgentWeb | 4.1.3 | Embedded webview runtime |
| xCrash | 3.1.0 | Native and Java crash telemetry |

## Build Instructions

### Prerequisites

- Android Studio (latest stable release recommended)
- JDK 17+
- Android SDK 36
- NDK 28.2.13676358 (required if compiling native components)

### Setup & Compilation

```bash
# Clone the main repository
git clone https://github.com/TIIEHenry/TaoKDao.git
cd TaoKDao

# Clone the required API repository (composite build dependency, must be at ../TaoKDao-API)
git clone https://github.com/TIIEHenry/TaoKDao-API.git ../TaoKDao-API

# Build Debug APK
./gradlew assembleDebug

# Build Release APK
./gradlew assembleRelease
```

## Plugin Development

TaoKDao supports modular extension via plugins. Plugins are packaged and distributed as standard APK files, loaded dynamically at runtime through `DynamicLoader`.

- Plugin APIs are defined in the `api_public` and `api_skin` modules.
- Plugins declare their configuration and entry points inside `META-INF/plugin.xml`.
- Runtime assets and classloaders are resolved via `createPackageContext`.

For detailed specifications and sample code, visit the [TaoKDao-API](https://github.com/TIIEHenry/TaoKDao-API) repository.

## Community & Feedback

| Channel | Link |
|---|---|
| QQ Group | [310289815](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=310289815) |
| GitHub Issues | [TIIEHenry/TaoKDao/issues](https://github.com/TIIEHenry/TaoKDao/issues) |

Pull requests and issues are welcome!

> **Note:** This is a legacy project started a few years ago. While the original Google Play developer account was suspended, the core architecture and technical design remain solid and functional.

## License

This project is released under an open-source license. Please refer to the `LICENSE` file in the root repository for full terms.

---

<p align="center">
  <sub>Built with ❤️ by TIIEHenry and contributors.</sub>
</p>
