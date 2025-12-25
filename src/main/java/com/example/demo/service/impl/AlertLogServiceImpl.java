@Service
public class AlertLogServiceImpl implements AlertLogService {

    private final AlertLogRepository repo;
    private final WarrantyRepository warrantyRepo;

    public AlertLogServiceImpl(AlertLogRepository repo, WarrantyRepository warrantyRepo) {
        this.repo = repo;
        this.warrantyRepo = warrantyRepo;
    }

    @Override
    public AlertLog addLog(Long warrantyId, String message) {
        Warranty warranty = warrantyRepo.findById(warrantyId).orElseThrow();

        AlertLog log = AlertLog.builder()
                .warranty(warranty)
                .message(message)
                .sentAt(java.time.LocalDateTime.now())
                .build();

        return repo.save(log);
    }

    @Override
    public List<AlertLog> getLogs(Long warrantyId) {
        return repo.findByWarrantyId(warrantyId);
    }
}
