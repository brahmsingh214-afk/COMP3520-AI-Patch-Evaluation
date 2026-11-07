# COMP3520 AI Patch Evaluation

When Green CI Lies: Stress-Testing AI-Generated Java Bug Fixes

## Research question

Among ChatGPT-generated Java patches that pass visible tests, how many fail independent checks?

## Requirements

- Java JDK 21 (original runs used 21.0.12)
- Windows PowerShell 5.1
- No external Java libraries

## Layout

Each directory under experiment contains a buggy starter, Visible.java, Independent.java, reference implementation, candidate patch, Prompt.txt, Run-Case.ps1, results.csv, and a screenshot of the observed runs. main-results.csv combines the eight main cases. The case plan describes the intended behavior.

The examples, reference implementations, tests, prompts, and runners were prepared with Codex assistance. Candidate patches were generated in fresh ChatGPT conversations. The exact ChatGPT model was not recorded. Chat formatting was removed from candidate responses where needed.

## Reproduce one case

Open PowerShell in the repository folder and run:

    .\experiment\AVG\Run-Case.ps1
    .\experiment\AVG\Run-Case.ps1 -Candidate "$PWD\experiment\AVG\reference\Average.java"
    .\experiment\AVG\Run-Case.ps1 -Candidate "$PWD\experiment\AVG\candidate\Average.java"

The first command tests the original buggy implementation. The other commands test the reference and saved AI candidate. Use the matching Java filename when running another case. Exit code 0 in the printed suite summary means pass. The printed summary records the suite outcomes separately.

## Recorded results

All eight candidates compiled and passed both suites. The observed additional failure rate was 0/8 among visible-passing candidates. All original implementations failed visible tests. Seven also failed independent checks. The TRANSFER original passed its independent checks. All reference implementations passed both suites.

These are small synthetic cases, with one candidate per case and a small set of independent checks. The tests cover selected behavior. Runs were performed locally with a PowerShell runner. Screenshots support the recorded outcomes.

## Data and sources

The eight cases are synthetic examples prepared for this project with AI assistance. No external benchmark dataset was used. The case plan and prompts are included so that expected behavior and repair inputs can be inspected.
