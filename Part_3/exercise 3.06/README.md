# Exercise 3.06: DBaaS vs DIY

A comparison of **Database as a Service (DBaaS)** and **DIY (Self-managed)** database solutions.

---

## **Comparison Table**

| Criteria                | DBaaS (e.g., AWS RDS, Google Cloud SQL)                                                                 | DIY (Self-managed on VMs/Kubernetes)                                                                 |
|-------------------------|--------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|
| **Initialization Work** | ✅ Minimal setup: Configure via provider UI/CLI. Automated infrastructure provisioning.                | ❌ High effort: Install DB software, configure storage, networking, security, and optimize performance. |
| **Initial Costs**       | ❌ Higher upfront costs (service fees, managed infrastructure).                                       | ✅ Lower upfront costs (only pay for compute/storage, no service fees).                              |
| **Maintenance**         | ✅ Fully managed: Automatic updates, scaling, patching, and monitoring.                               | ❌ Manual: Handle updates, scaling, troubleshooting, and monitoring yourself.                        |
| **Ongoing Costs**       | ❌ Predictable but higher costs (scales with usage).                                                  | ✅ Potentially lower for large-scale deployments (requires in-house expertise).                      |
| **Backup & Recovery**   | ✅ Built-in: Automated backups, point-in-time recovery, and easy restores via provider tools.         | ❌ Manual setup: Tools like `pg_dump`, cron jobs, or third-party solutions. Complex reliability.     |
| **Scalability**         | ✅ Seamless: Vertical/horizontal scaling managed by the provider.                                     | ❌ Manual: Requires sharding, replication, or infrastructure adjustments.                           |
| **Customization**       | ❌ Limited: Restricted to provider-supported configurations.                                         | ✅ Full control: Optimize performance, storage, and security for specific needs.                     |
| **Vendor Lock-in**      | ❌ High: Migrating to another platform can be complex.                                               | ✅ None: Use open-source tools and avoid proprietary systems.                                        |
| **Security**            | ✅ Managed: Provider handles encryption, access controls, and compliance certifications.              | ✅ Flexible: Custom security policies, but requires expertise to implement.                         |

