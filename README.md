# TestNG Canary Example

TestNG canary example with CloudWatch metrics.


## Getting started

Follow [directions to setup OIDC authentication to
AWS](https://docs.github.com/en/actions/deployment/security-hardening-your-deployments/configuring-openid-connect-in-amazon-web-services).

Create an IAM role for the canary. Use sample trust policy from OIDC setup
instructions and modify with the ARN of the identity provider you created and
the repo of the canary.

Add an inline policy to the canary role to allow `cloudwatch:PutMetricData`
action.

Copy the canary IAM role's ARN. This will be `AWS_ROLE_TO_ASSUME`.

Find the AWS region you want your metrics to show up in. This will be
`AWS_REGION`.

Add `AWS_ROLE_TO_ASSUME` and `AWS_REGION` secrets to Action secrets.

Deploy GitHub action.