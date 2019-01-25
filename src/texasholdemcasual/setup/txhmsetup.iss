; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{8BCBB1C3-F7A0-4A07-831A-2172C5732551}
AppName=Texas Hold'em Casual
AppVersion=1.0
;AppVerName=Texas Hold'em Casual 1.0
DefaultDirName={pf}\Texas Hold'em Casual
DefaultGroupName=Texas Hold'em Casual
OutputDir=C:\Projekte\Texas_Hold'em_Casual\src\texasholdemcasual\setup
OutputBaseFilename=setup
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"
Name: "german"; MessagesFile: "compiler:Languages\German.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "C:\Projekte\Texas_Hold'em_Casual\src\texasholdemcasual\txhm.exe"; DestDir: "{app}"; Flags: ignoreversion
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{group}\Texas Hold'em Casual"; Filename: "{app}\txhm.exe"
Name: "{group}\{cm:UninstallProgram,Texas Hold'em Casual}"; Filename: "{uninstallexe}"
Name: "{commondesktop}\Texas Hold'em Casual"; Filename: "{app}\txhm.exe"; Tasks: desktopicon

[Run]
Filename: "{app}\txhm.exe"; Description: "{cm:LaunchProgram,Texas Hold'em Casual}"; Flags: nowait postinstall skipifsilent

