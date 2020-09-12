[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
### Description
ByteLog64 is a debugging/logging tool, primarily for analyzing and comparing bytes sent between the N64 console and attached controller devices. It also has the capability to save Controller Pak dumps. This is intended to be used along side [PIC-CNT64](https://github.com/bigbass1997/PIC-CNT64), however, any device that streams bytes to a COM port should also work.

This project is still a work-in-progress, not all the features are complete. It was created with my own personal use in mind, but is released here as someone else may find it useful too.

### COM Port Data Format
The N64 Joybus Protocol transmits data in bytes, in addition to stop bits. The console always initiates communication with a 1 byte command. Some commands will also include additional bytes. The controller device may also send back data too. More indepth details can be read about on the [N64Brew Wiki](https://n64brew.dev/wiki/Joybus_Protocol).

While the tool is capable of reading any bytes sent to the COM port, if **Command Formatting** is turned on, it will expect both the command byte and any additional data from either the console or controller device. Then it will automatically format and color code the incoming data. The following commands are supported in this mode, any other commands sent will likely confuse the formatter, but it may be able to weed out the unknown bytes.

**Supported commands:** `0xFF`, `0x00`, `0x01`, `0x02`, `0x03`

### Building
Gradle is used as the dependency and build management software. Included in the repo is the Gradle Wrapper which allows you to run gradle commands from the root directory of the project. You can compile and run the program with `gradlew run`. To build the source into a runnable jar, execute `gradlew build`. The resulting jar will be located in `/build/libs/`.

To generate project files for IDEA and Eclipse: `gradlew idea` and `gradlew eclipse` respectively. Your IDE may also have the ability to import Gradle projects.
