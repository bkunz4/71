{ pkgs }: {
  deps = [
    pkgs.zulu
    pkgs.nodePackages.vscode-langservers-extracted
    pkgs.nodePackages.typescript-language-server  
  ];
}