Optimistic Locking:
=================
When an object(in clientApp1) is loaded and performed an modification and went for a sleep for a while or did not commit for sometime,
In the meantime if any other thread(in ClientApp2) have performed any modifications to the same record in DB.
Now when you try to save the object within previous thread then it will through you below Exception.

Exception in thread "main" javax.persistence.OptimisticLockException: Batch update returned unexpected row count from update [0]; 
actual row count: 0; expected: 1; statement executed: update InsurancePolicy set holderName=?, policyName=?, tenure=?, versioncount=? where id=? 
and versioncount=?

If we want to enable optimistic locking means that entity should contain an @Version attribute in an entity.
Internally Optimistic locking will perform actions based on these version count only.