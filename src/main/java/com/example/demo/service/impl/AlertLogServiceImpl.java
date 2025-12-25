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
        Warranty w = warrantyRepo.findById(warrantyId).orElseThrow();
        return repo.save(AlertLog.builder()
                .warranty(w)
                .message(message)
                .build());
    }

    @Override
    public List<AlertLog> getLogs(Long warrantyId) {
        return repo.findByWarrantyId(warrantyId);
    }
}
