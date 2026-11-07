param([string]$Candidate = "$PSScriptRoot/Retry.java")

$build = Join-Path ([System.IO.Path]::GetTempPath()) ([guid]::NewGuid().ToString())
New-Item -ItemType Directory -Path $build | Out-Null
try {
    & javac -d $build $Candidate "$PSScriptRoot/Visible.java" "$PSScriptRoot/Independent.java"
    if ($LASTEXITCODE -ne 0) { throw "Compilation failed" }

    & java -cp $build Visible
    $visible = $LASTEXITCODE
    & java -cp $build Independent
    $independent = $LASTEXITCODE
    Write-Output "Visible exit code: $visible. Independent exit code: $independent. Zero means pass."
} finally {
    Get-ChildItem -LiteralPath $build -Filter '*.class' | Remove-Item
    Remove-Item -LiteralPath $build
}


