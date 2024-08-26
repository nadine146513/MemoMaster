# MemoMaster: Interactive Text Memorization Tool
This Java Swing application is designed to help students enhance their memorization skills by interactively prompting them to recall missing words in a passage. With game-like mechanics such as multiple attempts and point tracking, the tool offers a fun and engaging way to study text-based materials. Ideal for students looking to improve their retention and recall abilities.

## Table of Contents
- [Screenshots](#screenshots)
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)


## Screenshots

<div style="display: flex; flex-wrap: wrap; justify-content: space-around;">
    <img src="https://github.com/user-attachments/assets/e93e7fae-730b-483e-92f5-b2c2aa0ea587" alt="Screenshot 2024-08-26 132355" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/b97b38c6-7c04-4f35-8e58-e272ab7c3ab6" alt="Screenshot 2024-08-26 132433" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/e0f52ad2-969e-407d-9fb3-dce891310944" alt="Screenshot 2024-08-26 135523" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/42f3b4ec-8541-496d-8f04-2cb7fd1edd8a" alt="Screenshot 2024-08-26 141706" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/a1561af6-9e90-46f7-8f6f-73598fd4654d" alt="Screenshot 2024-08-26 141750" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/9cad61d4-86c3-40eb-97d7-45bb4a189df9" alt="Screenshot 2024-08-26 142312" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/823e3e5d-5b5b-4ace-91a8-42b56c058f00" alt="Screenshot 2024-08-26 142409" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/c78a972d-d27b-436a-9746-07759ec7b890" alt="Screenshot 2024-08-26 142854" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/3d05df25-3c29-42d1-bc3b-d21069e2e4d0" alt="Screenshot 2024-08-26 143536" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/88a0e856-7b36-4467-a36b-36a99b82b86b" alt="Screenshot 2024-08-26 144516" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/28f30bbc-bc88-4314-9e3a-441d1f7dfa3e" alt="Screenshot 2024-08-26 145334" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/790284f0-ccf2-4f92-a4fc-a43504031771" alt="Screenshot 2024-08-26 150125" style="width: 30%; margin: 10px;"/>
    <img src="https://github.com/user-attachments/assets/26aa7b96-2c54-406b-b902-542d3602111e" alt="Screenshot 2024-08-26 151932" style="width: 30%; margin: 10px;"/>
</div>

## Installation

### Prerequisites
Before you begin, ensure you have the following installed on your machine:
- **Java Development Kit (JDK)**: Make sure you have JDK 8 or higher installed.
- **Git**: To clone the repository from GitHub.

### Steps
1. **Clone the Repository**
   - Open your terminal or command prompt.
   - Run the following command to clone the repository:
     ```bash
     git clone https://github.com/nadine146513/MemoMaster.git
     ```

2. **Navigate to the Project Directory**
   - Change to the directory where the project was cloned:
     ```bash
     cd MemoMaster
     ```

### Steps

3. **Compile the Project**
   - Navigate to the `src` directory:
     ```bash
     cd src
     ```
   - Compile the Java files manually using the following command:
     ```bash
     javac memorizeTool/gui/*.java memorizeTool/AudioPlayer.java
     ```
   - Alternatively, you can use an IDE like Eclipse, IntelliJ IDEA, or NetBeans to open the project and compile it automatically.

4. **Run the Application**
   - If you compiled the project manually:
     ```bash
     java memorizeTool.gui.MainFrame
     ```
   - If you have a pre-built JAR file (replace `MemoMaster.jar` with the actual file name):
     ```bash
     java -jar MemoMaster.jar
     ```
## Usage

1. **Launch the Application**
   - Upon opening the application, classical music designed to enhance focus will start playing automatically.

2. **Start a New Session**
   - Click the **Start** button to open a new window where you can enter the text you need to memorize.

3. **Enter Your Text**
   - Type or paste the text you wish to memorize into the provided field and click the **Submit** button.

4. **Play the Game**
   - The game begins with Round 1. Try to guess the missing words from the text. Press **Enter** after each guess.
   - If your guess is correct, the corresponding box will turn green, and you will earn one point.
   - If your guess is incorrect, the box will turn red, and you will lose one point.

5. **Progress Through Rounds**
   - The game consists of 8 rounds, with the number of missing words increasing progressively in each round.

6. **End of Game**
   - If your score reaches 0 points, the game ends, and you lose.
   - Successfully completing all 8 rounds means you win the game.
     
## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE.txt) file for details.
