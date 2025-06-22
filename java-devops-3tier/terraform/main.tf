provider "aws" {
  region = "ap-south-1"
}

resource "aws_instance" "devops_ec2" {
  ami           = "ami-0c768662cc797cd75"
  instance_type = "t2.micro"
  key_name      = "your-key-name"

  tags = {
    Name = "DevOpsEC2"
  }
}
