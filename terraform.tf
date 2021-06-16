provider "aws" {
  region     = "ap-south-1"
}
resource "aws_s3_bucket" "b" {
  bucket = "srees3bucketusingterraform"

  tags = {
    Name        = "My bucket"
  }
}
resource "aws_s3_bucket_object" "object" {
  bucket = "srees3bucketusingterraform"
  key    = "sreesra"
  source = "C:/Users/vscr9/.m2/sample/repository"

  #  The filemd5() function is available in Terraform 0.11.12 and later
  #  For Terraform 0.11.11 and earlier, use the md5() function and the file() function:
  # etag = "${md5(file("path/to/file"))}"
  etag = filemd5("C:/Users/vscr9/.m2/sample/repository")
}
