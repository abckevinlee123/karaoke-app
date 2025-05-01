import os
import subprocess
from demucs.separate import main as demucs_split
import torchaudio

torchaudio.set_audio_backend("soundfile")  # Add this at the top of your script

def split_audio(input_mp3):
    # 1. Run Demucs on the WAV
    demucs_split([
        "-n", "htdemucs",
        "--two-stems=vocals",
        input_mp3
    ])

    # 2. Clean up and show output paths
    base = os.path.splitext(os.path.basename(input_mp3))[0]
    output_dir = os.path.join("separated", "htdemucs", base)
    
    print(f"\n✅ Separation complete!")
    print(f"Vocals: {os.path.join(output_dir, 'vocals.wav')}")
    print(f"Backing: {os.path.join(output_dir, 'no_vocals.wav')}")

if __name__ == "__main__":
    split_audio("Milena_Dear_Barcelona.mp3")  # Replace with your file 